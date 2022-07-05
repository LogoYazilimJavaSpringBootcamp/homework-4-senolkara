# Kodlama çalışmaları _hmwrk4_ branch içerisinde bulunmaktadır.

### Cevap-1
1. answer1 içerisinde bulunan projede bir yapının MySQL veya PostgresSQL veritabanlarıyla çalışabilinmesi amaçlanmıçtır. Hem MySQL hem PostgresSQL için DataAccess katmanı içerisinde her entity ile bağlantılı olacak şekilde ayrı ayrı paketler ve class lar oluşturulmuştur. 
2. Herhangi bir controller üzerinde hangi veritabanı ile çalışacağını controller constructor metodu içerisinde belirtmemiz gerekmektedir. Bunu da polimorfizm den yararlanarak yapıyoruz.
3. Örneğin MySQL ile çalışılacaksa MySQLUserDao, PostgresSQL ile çalışılacaksa PostgresSQLUserDao class larının çağırılması gerekmektedir. Sonuç olarak burada Dependecy Injection yapmış oluyoruz.
4. homework-3 içerisinden RabbitMQ ile gönderilen bir class ı bu örnekte Listener package içerisindeki RabbitListener annotation ile belirtilmiş metod yardımıyla dinliyor ve işleme alıyoruz. Bu bahsi geçen çalışmada sadece User entity class ı üzerinde çalışılmıştır.
5. homework-3 adlı projemiz localhost:8083 üzerinde çalışmakta ve RabbitMQ ile verileri göndermekte olup homework-4/answer1 içerisindeki projemiz ise localhost:8084 portu üzerinde çalışmaktadır ve verileri dinleyip işleme almaktadır.


_UserController endpointleri_
---
GET -> localhost:8084/user-api
---
GET -> localhost:8084/user-api/{id}
---
POST -> localhost:8084/user-api
---
PATCH -> localhost:8084/user-api/{id}/{addressId}
---
DELETE -> localhost:8084/user-api/{id}
---

_ProductController endpointleri_
---
GET -> localhost:8084/product-api
---
GET -> localhost:8084/product-api/{id}
---
POST -> localhost:8084/product-api
---
PATCH -> localhost:8084/product-api/{id}
---
DELETE -> localhost:8084/product-api/{id}
---

_ProductCommentController endpointleri_
---
GET -> localhost:8084/product-comment-api
---
GET -> localhost:8084/product-comment-api/{id}
---
POST -> localhost:8084/product-comment-api
---
PATCH -> localhost:8084/product-comment-api/{id}
---
DELETE -> localhost:8084/product-comment-api/{id}
---

### Cevap-2
JDBC, JDCB Template ve Hibernate ile Dao katmanı yazılmaya çalışılmıştır. 
Yapılan çalışmalar sonucunda veri tipinin güvenliğinin ön planda olması göze çarpıyor. Fakat veritabanında yapılacak herhangi bir değişiklikte kodların tekrar gözden geçirileceği ve kendimizi tekrar etmemiz gerekeceği (DON'T REPEAT YOURSELF), veritabanı kolonlarının sırasına göre veriler indexlenerek set edileceğinden dolayı dikkatten kaçacak birçok kolon, sıra, veri, veri tipinin olabileceği dezavantajlar olarak görülebilir. Bunlara ek olarak her çalışmada tekrar sorgu yazılması ihtimali, ulaşılmak istenilen verinin türü, durumu, çokluğuna göre bu sorgular daha da karmaşık hale gelebileceği de ihtimal dahilindedir.

### Cevap-3

MongoDB vs. Couchbase

    Yükleme ve Yapılandırma İşlemleri

    – Couchbase, sağladığı Admin UI’ı sayesinde tek bir yerden tüm yapılandırma işlemlerini yönetmemize olanak sağlamaktadır.
    – MongoDB’de ise yapılandırma işlemleri için tüm yapılandırma ayarlarını manuel olarak ayrı ayrı şekilde yapmamız gerekmektedir.
    Memory Kullanımı

    – Couchbase yüksek performanslı MemCached protokolünü kullanarak herhangi bir Cache mekanizması ihtiyacını ortadan kaldırır.
    – MongoDB’de ise yüksek performans ve scale işlemlerini yönetebilmek için third-party Cache tool’larına ihtiyaç vardır.
    Maintenance (Bakım) İşlemleri

    – Couchbase’de maintenance işlemlerini Web UI, Couchbase Cli veya Rest Api’lar üzerinden gerçekleştirebilmemize olanak sağlamaktadır.
    – MongoDB’de ise maintenance işlemleri için sadece Cli araçlarını kullanabilmekteyiz. Third-party araçlarını kullanarak bir UI yardımı ile de maintenance işlemlerini gerçekleştirebiliriz.
    Desteklenen Programlama Dilleri

    Couchbase, MongoDB kadar geniş dil desteği vermese de C#, Go, Java ve Python gibi popüler dillere desteği ile muadilinden çok geride kalmamıştır.

/* MongoDB */
db.CUSTOMER.find({customerId:"C123"})

/* Couchbase: N1QL */
SELECT * FROM CUSTOMER WHERE customerId = "C123";

/* MongoDB */
db.CUSTOMER.save({_id: "C123", 
{“id”: “C123”, “firstName”: “Şefik Can”, "lastName":"Kanber"})
 
/* Couchbase:N1QL */
INSERT INTO CUSTOMER(KEY, VALUE) VALUES
(‘C123’, {“id”: “C123”, “firstName”: “Şefik Can”, “lastName”:"Kanber"})


/* MongoDB */
db.CUSTOMER.update({_id:"C123"},{"firstName":"Mehmet"})

/* Couchbase:N1QL */
UPDATE CUSTOMER SET "firstName" = "Mehmet" WHERE id = "C123"

/* MongoDB */
db.CUSTOMER.remove({_id:"C123"})
 
/* Couchbase:N1QL */
DELETE FROM CUSTOMER WHERE id = "C123";


/* MongoDB */
$group : {
         [
           { a:”$a”}, {b:”$b”}, {c: “$c”},
           count: { $sum: 1 }
        ]
       }
       
/* Couchbase: N1QL */
SELECT b, c, SUM(a)
FROM t
GROUP BY b, c

/* MongoDB */ 
ORDER BY
     { $sort : { age : -1, posts: 1 } }
 
/* Couchbase: N1QLL */
ORDER BY age DESC, posts ASC


Redis

Yüksek Performans

- Redis, verileri disklerde (HDD veya SSD) tutan veri tabanlarının akside bellek (RAM) üzerinde tutar bu sayede disklere erişim ihtiyacını ortadan kaldırarak gecikmeleri, I/O bağlantılarını önler ve daha az CPU kullanan basit algoritmalar ile verilere erişir.
In-Memory Veri Yapıları

- Redis verileri bellek üzerinde <key,value> çifti olarak tutmaktadır, burada herbir anahtara denk gelen değerler farklı veri yapılarında tutulabilmektedir. Bu veri yapıları; String, List, Hash, Set, Sorted Set, Bitmaps, HyperLogLogs, Geospatial Indexes

- Redis kullanılarak neredeyse her türlü veri bellekte saklanabilir.
- 
Replication

- Redis, master-slave mimarisini kullanır, master genel olarak yazma işlemlerini yapar ve slave dediğimiz yapılar da master’in birer kopyasıdır, master güncellendikçe ona bağlı bütün slave’ler de güncellenir. Burada master’da oluşacak herhangi bir çökmede, hatada direkt bir slave master olarak seçilir ve sistem çalışmaya devam eder.
Persistance (Veri Kalıcılığı)

- Redis’te verilerin RAM üzerinde saklandığından bahsettik, olası bir elektrik kesintisi, sunucu kapanması gibi durumlarda veriler silinecektir. Redis bize iki yöntem sunmaktadır verinin kalıcılığını sağlamak için. Bunlar; point-in-time Snapshots ve Append Only File (AOF).

- Snapshots yönteminde belirli zaman aralıkları ile RAM üzerindeki verinin kaydı, kopyası diske kayıt edilir bu sayede olası bir elektrik kesintisi gibi durumlarda disk üzerinden verilere tekrar geri dönülebilir.

- Append Only File yönteminde ise her değişikliği dosyanın sonuna yazarak oluşan veri değişikliklerinin kaydını tutar.
Çoklu Dil Desteği

- Redis birçok dil tarafından desteklenmektedir, bunlar; Java, Python, PHP, C, C ++, C #, JavaScript, Node.js, Ruby, R, Go gibi dillerdir ve bunların yanı sıra daha fazla da dil bulunmaktadır.

Bazı komutlar

String veri ekleme komutu:
SET firstName deneme

Anahtar değeri ile string veriyi alma komutu:
GET firstName

Değerin sonuna string ekleme komutumuz:
APPEND firstName " redis"

Bütün anahtar değerlerini çağırma  komutu:
KEYS *

Anahtar değeri ile veri silme komutu:
DEL firstName

Sonuç olarak kullanılan bu üç farklı teknoloji, ilişkisel veritabanlarından ve geleneksel veritabanı yönetim şekillerinden farklı olarak bizlere performans, kapasite ve esneklik sağlıyor.

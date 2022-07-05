# Kodlama çalışmaları _hmwrk4_ branch içerisinde bulunmaktadır.

1. Mysql veya PostgreSQL ile controller katmanlarının çalışabilmesi için gerekli repository katmanlarını yazın. Ayrıca isbasi-email-service kuyruktan veriyi okuduktan sonra gerekli model class’ını oluşturup tabloya kaydedin.(60 Puan)
2. JDBC, JdbcTemplate ve Hibernate ile bir DAO katmanını yazın ve avantajlarını ve dezavantajlarını kendi görüşlerinizle beraber yazın. OOP’nin polimorfizm’den yararlanarak aynı tabloya üç yöntem ile CRUD işlemlerini yapan kodu yazınız. (30 Puan)
3. Aşağıdaki kavramları örneklerle açıklayın ve hangi problemi nasıl çözdüklerini anlatan bir makale yazın.(Medium’da paylaşıp linkini koyabilirsiniz.) (10 Puan)
  * MongoDB,
  * Coucbase,
  * Redis

## Cevaplar
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

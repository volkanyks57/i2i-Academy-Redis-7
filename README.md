# i2i-Academy-Redis-7
Redis ve RedisInsight ile in-memory caching uygulaması

# Özet
  Bu projede Docker ile Redis ve RedisInsight container'ları çalıştırıldı. 
  Jedis kütüphanesi kullanılarak Java ile Redis'e bağlanan bir client uygulaması geliştirildi.
  10.000 Person objesi Redis'e eklendi ve başarıyla okundu.

# Tamamlanan Görevler
  - Docker Compose ile Redis ve RedisInsight container'ları başlatıldı
  - RedisInsight dashboard'undan Redis'e bağlantı kuruldu
  - Java ile Jedis client kullanılarak Redis'e bağlantı sağlandı
  - Person class oluşturuldu (id, name, age alanları)
  - 10.000 Person objesi JSON formatında Redis'e eklendi
  - Redis'ten objeler okunarak konsola yazdırıldı ve doğrulandı

# Kullanılan Teknolojiler
  - Docker
  - Redis
  - RedisInsight
  - Java 21
  - Maven
  - Jedis (Redis Java Client)
  - Gson (JSON dönüşümü)

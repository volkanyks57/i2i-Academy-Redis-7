package i2iacademy;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

public class RedisClient {

    // Redis bağlantı ayarları
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    private static final int TOTAL_RECORDS = 10_000;

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {

            System.out.println("Redis bağlantısı kuruldu: " + jedis.ping());

            System.out.println("\n" + TOTAL_RECORDS + " Person objesi ekleniyor...");
            long startTime = System.currentTimeMillis();

            for (int i = 1; i <= TOTAL_RECORDS; i++) {
                Person person = new Person(i, "Person-" + i, 20 + (i % 50));
                String json = gson.toJson(person);
                jedis.set("person:" + i, json);
            }

            long insertTime = System.currentTimeMillis() - startTime;
            System.out.println(TOTAL_RECORDS + " kayıt eklendi! Süre: " + insertTime + " ms");

            System.out.println("\nRedis'ten ilk 5 kayıt okunuyor...");
            for (int i = 1; i <= 5; i++) {
                String json = jedis.get("person:" + i);
                Person person = gson.fromJson(json, Person.class);
                System.out.println(person);
            }

            // Toplam kayıt sayısını doğrula
            System.out.println("\nRedis'teki toplam 'person' anahtarı sayısı: " +
                    jedis.keys("person:*").size());

        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }
}
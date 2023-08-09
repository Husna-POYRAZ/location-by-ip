
# Location Service By IP Projesi

Proje, IP adresine göre kişilerin bulunduğu yeri tespit eden bir servis olarak tasarlanmıştır. Aşağıda proje yapısı, paketler ve özet açıklamalar yer almaktadır:

## Proje Yapısı
Proje, temiz ve düzenli bir yapıda geliştirilmiştir. Ana proje klasörü location-by-ip olarak adlandırılmıştır ve aşağıdaki alt klasörleri içermektedir:

- **src:** Projenin kaynak kodlarını içeren klasördür.
    - **asset:** MMDB dosyasını içeren klasör, projenin çalışması için gereklidir.
    - **main:** Ana uygulama kaynak kodları bu klasörde yer alır.
        - **java:** Java kaynak kodları bu klasör altında bulunur.
            - **com.hpoyraz.locationbyip:** Java paketi, uygulama sınıflarını içerir.
                - **controller:** API endpoint'ini tanımlayan controller sınıfı burada bulunur. Bu paket, uygulamanın API'larını yönetmek ve gelen istekleri işlemek için kullanılır.
                - **exception:** Bu paket, özel hataları tanımlamak ve fırlatmak için kullanılır.
                - **model:** Konum bilgilerini temsil eden model sınıfı burada yer alır.
                - **service:** Bu paket, iş mantığına sahip olan ana bileşenlerin yer aldığı pakettir.
                  - **impl:** Gerçek iş mantığının uygulandığı paket.
                  - **interfaces:** Servis arabirimlerinin tanımlandığı paket.
                - **util:** Yardımcı fonksiyonların bulunduğu pakettir.
                  - **constants:** Sabit verilerin ve yapılandırmaların yer aldığı paket. 
        - **resources:** Bu klasörde, farklı ortamlar için yapılandırma dosyaları yer almaktadır.
          - **application.yml:** Genel yapılandırma ayarları.
          - **application-dev.yml:**  Geliştirme ortamı yapılandırma ayarları.
          - **application-prod.yml:** Prodüksiyon ortamı yapılandırma ayarları.
    - **test:** Ana uygulama kaynak kodlarına ait testler bu klasörde yer alır.
      - **java:** Java kaynak kodları bu klasör altında bulunur.
          - **com.hpoyraz.locationbyip:** Java paketi, uygulama test sınıflarını içerir.
              - **service:** Konum bilgilerini elde eden servis sınıfına ait unit test sınıfı bu klasör altında bulunur.
- **Dockerfile:** Docker imajının nasıl oluşturulacağını belirten dosyadır. Projenin bağımlılıkları ve çalıştırılacak JAR dosyası tanımlanır.
- **docker-compose.yml:** Docker Compose dosyasıdır ve **location** Docker container'ının tanımlandığı dosyadır. Proje içindeki servisin nasıl çalışacağı ve yapılandırmaları burada belirtilmiştir.
- **pom.xml:** Projenin Maven proje tanımlama dosyasıdır. Bağımlılıklar ve yapılandırma bu dosyada belirtilir.

## Kullanılan Teknolojiler ve Kütüphaneler

- **Java 17:** Java programlama dilinin ileri bir sürümüdür ve geliştiricilere daha güçlü ve verimli bir dil deneyimi sunar. Yeni özellikler ve iyileştirmelerle doludur ve performans açısından da geliştirmeler içerir.

- **Spring Boot (Versiyon: 2.5.3):** Spring Boot, Spring ekosistemini kullanarak hızlı ve basit şekilde web uygulamaları, mikro hizmetler ve RESTful API'ler oluşturmayı kolaylaştıran bir framework'tür. Spring Boot, otomatik yapılandırma ve hazır özellikler sağlayarak geliştirme sürecini hızlandırır ve geliştiricilere kod tekrarını önlemeye odaklanmalarına olanak tanır.

- **MaxMind GeoIP2 (Versiyon: 4.0.1):** MaxMind GeoIP2, IP adresine dayalı konum bilgilerini elde etmek için kullanılan bir kütüphanedir. GeoIP2 veritabanı kullanılarak IP adreslerini ülkeler, şehirler, coğrafi konumlar ve zaman dilimleri gibi çeşitli konum özellikleriyle eşleştirebilir. Bu sayede IP adresleri üzerinden kullanıcıların coğrafi konumlarını tespit etmek mümkün olur.

- **Docker (Versiyon: 20.10.8):** Docker, uygulamaları, bağımlılıkları ve konfigürasyonları bir araya getirerek hafif, taşınabilir ve ölçeklenebilir konteynerler oluşturmayı sağlayan bir platformdur. Docker sayesinde uygulamaları izole edebilir, farklı ortamlarda sorunsuz bir şekilde çalıştırabilir ve dağıtım süreçlerini kolaylaştırabilirsiniz.

- **Lombok (Versiyon: 1.18.26):** Lombok, Java'da boilerplate kodu azaltmak ve daha sade ve okunabilir sınıflar oluşturmak için kullanılan bir kütüphanedir. Getter, Setter, Constructor gibi tekrarlayıcı kodları otomatik olarak oluşturarak kodu temiz ve düzenli tutar. Bu sayede geliştiriciler daha az tekrarlayıcı kod yazmak zorunda kalır ve daha az hata yaparlar.

- **JUnit (Versiyon: 5.8.0):** JUnit, Java programlama dili için yazılım testleri oluşturmak ve çalıştırmak için kullanılan bir test çerçevesidir. Test Driven Development (TDD) ve Unit Testing gibi yazılım geliştirme yöntemlerinde yaygın olarak kullanılır. JUnit, testlerin otomatik olarak çalıştırılmasını ve sonuçların raporlanmasını sağlar, böylece geliştiriciler kodun doğruluğunu ve kalitesini sağlamak için kolayca testler yapabilirler.

## Kullanım Notları
- Proje, IP adresine göre konum bilgilerini elde etmek için MaxMind GeoIP2 kütüphanesini kullanır.
- MMDB dosyası olmadan proje kullanılamaz. Bu nedenle projenin çalışması için [GeoLite2-City.mmdb](https://www.maxmind.com/en/accounts/887440/geoip/downloads) dosyasının projenin asset klasöründe bulunması gerekmektedir.
- Servis geçerli bir IP adresiyle çağrıldığında konum bilgilerini döndürürken, geçersiz veya hatalı bir IP adresiyle çağrıldığında **"Hata: Konum bilgisi alınamadı."** bilgisiyle 500 Internal Server Error dönecektir.


## Proje Kurulum ve Çalıştırma
1. GeoLite2-City.mmdb dosyasını MaxMind adresinden ücretsiz olarak indirin ve proje ana dizinine asset klasörü içine ekleyin.

2. Proje ana dizininde aşağıdaki komutu çalıştırarak proje bağımlılıklarını yükleyin:

```bash
  mvn clean install
```

3. Docker'ı ve Docker Compose'u bilgisayarınıza yükleyin.

4. Docker image'ı oluşturmak için aşağıdaki komutu çalıştırın:

```bash
  docker build -t location-by-ip:0.1 .
```

5. Projenin Docker container'ında ayağa kaldırmak için aşağıdaki komutu çalıştırın:

```bash
  docker-compose up
```

6. Servis, varsayılan olarak **8585** portunda çalışacaktır. Tarayıcınızı veya API test aracınızı kullanarak aşağıdaki URL'ye erişebilirsiniz:

```bash
  http://localhost:8585/location/{ipAddress}
```


| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `ipAddress` | `string` | **Gerekli**. Çağrılacak öğenin ip adresi |

#### Örnek Kullanım
```bash
  GET http://localhost:8585/location/176.88.4.170
```

#### Örnek Sonuç
```bash
{
    "ip": "176.88.4.170",
    "network": "176.88.4.0/23",
    "countryName": "Türkiye",
    "city": "Istanbul",
    "continentName": "Asia",
    "continentCode": "AS",
    "timeZone": "Europe/Istanbul",
    "latitude": 41.0145,
    "longitude": 28.9533
}
```

## Docker Hub Üzerinden Image Kullanımı
1. **docker-compose.yml** dosyası içinde service oluşturun ve burada  Docker Hub da yer alan **[husnapoyraz/location-by-ip:0.1](https://hub.docker.com/repository/docker/husnapoyraz/location-by-ip/general)** image'ini çekin:

#### Örnek Kullanım
```bash
  location_service:
    image: husnapoyraz/location-by-ip:0.1
    container_name: location_service
    ports: 
      - ${LOCATION_SERVICE_PORT}:${LOCATION_SERVICE_PORT}
    networks:
      url_shortener:
```

2. Projenin Docker container'ında ayağa kaldırmak için aşağıdaki komutu çalıştırın:

```bash
  docker-compose up
```

Not: Docker kullanım hakkında daha fazla bilgiye ulaşmak için **Ahmet Emre Demirşen**'in [medium](https://medium.com/@aedemirsen/docker-i%CC%87maj%C4%B1n%C4%B1-bir-container-registry-%C3%BCzerinde-depolamak-23b056658a7d) yazısına bakabilirsiniz.

## Dockerfile

```bash
FROM openjdk:17

WORKDIR /app

COPY /asset /app/asset

ARG JAR_FILE=/target/*.jar

COPY ${JAR_FILE} /app/location-by-ip.jar

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "location-by-ip.jar"]
```

## docker-compose.yml

```bash
version: '3.8'
services:
  location:
    image: location-by-ip:0.1
    container_name: location
    ports:
      - "8585:8585"
```

## Testler
Proje, JUnit ve Spring Boot test framework'ü kullanılarak test edilmiştir. Testler, farklı senaryolarda projenin doğru çalıştığından emin olmak için yazılmıştır. Testler, test/java klasörü altında bulunur ve LocationServiceTest adlı test sınıfı örnek olarak eklenmiştir.

```bash
// LocationServiceTest.java
package com.hpoyraz.locationbyip.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.hpoyraz.locationbyip.model.Location;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LocationServiceTest {
    private LocationService locationService;

    @BeforeEach
    public void setUp() {
        locationService = new LocationService();
    }

    // Testler burada devam eder...
}
```

## Katkılar ve Lisans
Katkılarınızı bekleriz! Lütfen pull request göndererek projeye katkıda bulunun. Bu proje MIT lisansı altında dağıtılmaktadır.

## Geri Bildirim

Herhangi bir geri bildiriminiz varsa, lütfen husnapoyraz88@gmail.com adresinden bize ulaşın.

## Teşekkürler
Bu proje, topluluk katkıları ve açık kaynak yazılımlar kullanılarak geliştirilmiştir. Bu nedenle projenin geliştirilmesine katkıda bulunan herkese teşekkür ederiz.

# Geolocation Component

Esta é uma aplicação Java desenvolvida no Eclipse IDE, utilizando o Maven como ferramenta de gerenciamento de dependências. A aplicação consiste em um componente de geolocalização que utiliza a API da MaxMind para obter dados de localização do usuário com base no IP da máquina.

## Funcionalidades

A aplicação recupera a localização do usuário (país, cidade, estado, latitude e longitude) com base no IP da máquina, utilizando o banco de dados da MaxMind.

## Estrutura do Projeto

### Classes Principais

#### `PresentLocation`

Uma classe concreta que representa a localização do usuário recuperada através do IP.

**Campos:**
- `countryName` (String): Nome do país.
- `cityName` (String): Nome da cidade.
- `state` (String): Nome do estado.
- `latitude` (double): Latitude da localização.
- `longitude` (double): Longitude da localização.

#### `PresentLocationFactory`

Uma classe que segue o padrão de projeto Factory, responsável por criar novas instâncias de `PresentLocation`, trazendo maior flexibilidade e reusabilidade ao código.

#### `LocationConfiguration`

Classe que gerencia a maior parte do componente de geolocalização.

**Métodos:**
- `getLocation()`: Busca no banco de dados local na pasta `resources` um endereço compatível com o endereço IP recuperado, busca os dados e passa para a fábrica (`PresentLocationFactory`), que irá retornar um `PresentLocation`.
- `getIPAddress()`: Método privado responsável pela busca do endereço IP da máquina. Isso é feito lendo o fluxo de dados de uma conexão com uma URL definida que retorna o endereço IP do host. Este método é chamado apenas pelo `getLocation()`.

## Configuração e Execução

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior.
- Apache Maven.
- Eclipse IDE (ou qualquer outra IDE de sua preferência).

### Dependências

Adicione as seguintes dependências no `pom.xml` do seu projeto:

```xml
<dependencies>
    <dependency>
        <groupId>br.com.ucsal</groupId>
        <artifactId>geolocate</artifactId>
        <version>0.0.1</version>
        <scope>system</scope>
        <systemPath>${geolocate-systemPath}</systemPath>
    </dependency>
    <dependency>
        <groupId>com.maxmind.geoip2</groupId>
        <artifactId>geoip2</artifactId>
        <version>4.2.0</version>
    </dependency>
</dependencies>

<properties>
    <geolocate-systemPath>
        C:\Users\CAMINHO_DO_JAR_NA_PASTA_RESOURCES\geolocate-0.0.1.jar
    </geolocate-systemPath>
</properties>
```


## Banco de Dados Local

A aplicação utiliza o banco de dados `GeoLite2-City`, que deve ser baixado e colocado na pasta `resources` junto com o jar do componente.

## Passos para Configurar
1. Inclua o banco de dados GeoLite2-City na pasta resources:
2. O banco de dados GeoLite2-City pode ser baixado em https://dev.maxmind.com/geoip/geolite2-free-geolocation-data.
3. Extraia o arquivo .tar.gz e coloque o arquivo .mmdb na pasta resources do seu projeto.
OU
1. Clone o repositório do projeto:
   ```sh
   git clone https://github.com/COMPONENTE-DE-GEOLOCALIZACAO/geocomponent


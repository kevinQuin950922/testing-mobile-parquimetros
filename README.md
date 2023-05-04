# Configuración SauceLabs y BrowserStack

# Configuración SauceLabs

En principio para la configuración de la granja móvil con SauceLabs debemos de crear una cuenta en SauceLabs y posteriormente dirigirnos a la pestaña de “Get Started Guide” y posteriormente seleccionamos “Automated testig” y damos click en Appium.

Todo esto con el objetivo de obtener las capabilities mucho mas rápido. Seleccionamos la plataforma y lenguaje (Android o iOS) y subimos nuestra aplicación para que quede en el sistema.

De esta forma tendremos a la mano las principales capabilities para enlazarnos con nuestra granja móvil.

```java
webdriver.driver=appium
appium.hub=https://<username>:<password>@ondemand.us-west-1.saucelabs.com:443/wd/hub
appium.username = <username>
appium.accessKey = <password>
appium.automationName=UiAutomator2
appium.platformName=Android
appium.platformVersion=12.0
appium.deviceName=Android GoogleAPI Emulator
appium.app=storage:filename=flypass parquimetrosV51.apk
appium.newCommandTimeout=1000
saucelabs.build=appium-build-41YIU
saucelabs.name=PruebaEnLineaFlyPassParquimetro
```

Nota: En las capabilities indicadas por SauceLabs el URL (hub) envés de “us-west-1” lleva android o ios, sin embargo para una correcta conexión debemos cambiarlo a como se puede observar en el código anterior (us-west-1).

# Configuración BrowserStack

La configuración en BrowserStack de igual forma es muy sencilla, posterior a la creación de nuestra cuenta lo primero que debemos de hacer es ir a la pestaña de “Upload”, la cual nos permitirá subir nuestra aplicación y generar el token de acceso a dicha aplicación.

Ya con la aplicación subida, nos dirigimos a la pestaña de “Access key” y obtenemos las credenciales de “Username” y “Access Key”.

Posterior a esto nos podemos dirigir a la página:

[BrowserStack - Capabilities for running mobile app tests on BrowserStack](https://www.browserstack.com/app-automate/capabilities)

Donde haremos la selección de nuestra configuración y se generaran las capabilities, en este paso también puedes realizar la selección de los dispositivos disponibles para pruebas.

```java
webdriver.driver=appium
appium.hub=https://<username>:<access key>@hub-cloud.browserstack.com/wd/hub
appium.app=<token generado de aplicación>
appium.automationName=uiautomator2
appium.platformName=Android
browserstack.user=<username>
browserstack.key=<access key>
appium.device=Google Pixel 3
appium.os_version=9.0
appium.newCommandTimeout=1000
```

Ya con esta configuración se tendrá acceso sin problema a la granja de BrowserStack.
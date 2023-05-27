Feature: Login
  Como un usuario de flaypass
  Quiero autenticarme en la aplicacion
  para que verifique las credenciales

  @test
  Scenario: Error login en flypass con contrasena incorrecta
    When Se ingresa bien el usuario y mal la contrasena
    Then Debe mostrar un mensaje de usuario y contrasena incorrectos

  @test
  Scenario: Usuario y contrasena correctos
    When Se ingresa bien el usuario y contrasena
    And Se ingresa token OTP
    Then Debe mostrar la pantalla inicial

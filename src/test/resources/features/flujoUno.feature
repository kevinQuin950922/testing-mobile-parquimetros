Feature: Escenarios flujo uno
  Como un usuario de flaypass
  Quiero poder validar los flujos correspondientes al flujo uno
  para validar que estan desarrollados correctamente

  @test
  Scenario: Flujo por notificación, validar mensaje
    Given Se tiene una transacción por cobrar
    When Cuando llegue la notificación
    Then Se valida que el mensaje esté de forma correcta

  @test
  Scenario: Flujo por notificación, validar denegar servico
    Given Se tiene una transacción activa
    When Cuando se ingrese a la notificacion
    Then Se valida que se pueda denegar el servicio

  @test
  Scenario: Flujo por notificación, validar aceptar transacción
    Given Se tiene una transacción activa por pagar
    When Cuando se ingrese a la notificacion
    Then Se valida que se pueda pagar el servicio


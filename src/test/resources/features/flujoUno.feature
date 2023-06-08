Feature: Escenarios flujo uno
  Como un usuario de flaypass
  Quiero poder validar los flujos correspondientes al flujo uno
  para validar que estan desarrollados correctamente

  @flujouno
  Scenario: Flujo por notificación, validar mensaje
    Given Se tiene una transacción por cobrar
    When Cuando llegue la notificación
    Then Se valida que el mensaje esté de forma correcta

  @flujouno
  Scenario: Flujo por notificación, validar denegar servico
    Given Se tiene una transacción activa
    When Cuando se ingrese a la notificacion
    Then Se valida que se pueda denegar el servicio

  @flujouno
  Scenario: Flujo por notificación, validar aceptar transacción
    Given Se tiene una transacción activa por pagar
    When Cuando se ingrese a la notificacion
    Then Se valida que se pueda pagar el servicio

  @flujouno
  Scenario: Validar aumentar tiempo de estacionamiento
    Given Se tiene un servicio en curso
    When Cuando se ingrese al detalle del servicio en curso
    Then Se valida que se pueda adicionar tiempo

  @flujouno
  Scenario: Validar pantalla tarifas
    Given Se tiene un servicio en curso
    When Cuando se ingrese al detalle del servicio en curso
    Then Se valida que se pueda ingresar a la pantalla de tarifas

  @flujouno
  Scenario: Validar finalizar estacionamiento
    Given Se tiene un servicio en curso
    When Cuando se ingrese al detalle del servicio en curso
    Then Se valida que se pueda finalizar el estacionamiento



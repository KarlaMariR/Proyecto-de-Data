# Proyecto-de-Data
Titulo:
Sistema de Manejo de Consultas Medicas:

Descripción:
Este proyecto es un sistema de gestion para una oficina oftálmica en Mayaguez. Usando Java se pudo resolver problemas de manejo de citas y organización de los datos del personal como pacientes y los empleados. El sistema se puede utilizar para registrar pacientes (normal o emergencia y prioridad o no ) y empleados con sus diferentes trabajos y especialidades. Tambien se puede hacer citas y cancelarlas, asignar pacientes, ver los medicos disponibles, mantener un historial clinico de los procesos y más. 

Instalacion:
Para ejecutar el proyecto localmente con el terminal:
1. Tener instalado el kit de desarrollo de Java version 8 o más.
2. Descargar el codigo, por clonear el repo o descargar los files en el repo, es possible que se haga un release al final.
3. Abrir el terminal, navega los files y ejecuta [ java MedicalRecordSystem ]
4. Tambien para ver los test que funcionen usa el right click en el file y usa "Run Java".

Uso:
El sistema está diseñado para ser probado mediante archivos de prueba (Test) que simulan el flujo de trabajo de la oficina. El flujo típico de uso es el siguiente:
Registrar al personal: Dar de alta a los médicos con sus especialidades (General, Pediátrico, Neuroftalmólogo, Retinólogo), enfermeros y secretarias.
Registrar pacientes: Añadir pacientes al sistema asegurando que su ID sea único.
Flujo de Atención (Escenario Típico):

    1. El paciente llega y se añade a la fila de espera (addToWaitingQueue).

    2. El médico se marca como disponible y se le asigna el siguiente paciente (assignPatientToDoctor).

    3. El médico atiende al paciente y registra la visita con su diagnóstico (registerMedicalVisit).

    4. El médico vuelve a estar disponible para el siguiente paciente.

Configuración:
No se necesita configurar para usarlo ya que no usamos files externos

Autores y las librerias utilizadas:

Adrián Antommattei González ( adrian.antommattei@upr.edu )
Karla Rodriguez Beauchamp ( Karla.rodriguez@upr.edu )
Faith Martinez ( faith.martinez@upr.edu )

java.util:
    Queue
    LinkedList
    Scanner
    List
    ArrayDeque
    ArrayList
    Deque
    HashSet
    HashMap
    Set
    Map
    PriorityQueue

java.time:
    LocalDateTime
    LocalDate
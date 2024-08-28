SISTEMA HOSPITALARIO
Este proyecto implementa un sistema de gestión hospitalaria en Kotlin, permitiendo el registro y manejo de empleados, pacientes, médicos y citas médicas.

CARACTERISTICAS

Registro de empleados (por planilla y eventuales)
Registro de pacientes
Registro de médicos
Programación de citas médicas
Listado de médicos por especialidad
Listado de pacientes atendidos por un médico específico

REQUISITOS

Kotlin 1.5 o superior JDK 8 o superior


EJERCICIO: El departamento de Informática de un hospital está realizando un nuevo registro de datos de todas las personas que tienen relación con esa institución, que son: los empleados, los médicos y los pacientes, Los empleados son categorizados en función de si son contratados por Planilla o de forma Eventual y son los encargados de los procesos administrativos. Los médicos (que podrían considerarse un tipo especial de empleados contratados por Planilla) se encargan de las atenciones de las consultas médicas. Para solicitar una cita, el paciente es atendido por un empleado. El paciente indica el servicio en el cual quiere pasar consulta y el empleado le indica el nombre del médico, la fecha y la hora de la cita. Los atributos de cada uno de ellos se indican a continuación: Persona: número de DNI, nombre, apellido, fecha de nacimiento, dirección, ciudad de procedencia. Paciente: número de historia clínica, sexo, grupo sanguíneo, lista de medicamentos a los que esalérgico. Empleado: código de Empleado, número de horas extras, fecha de ingreso, área, cargo. Empleado por Planilla: salario mensual, porcentaje adicional por hora extra. Empleado Eventual: honorarios por hora, número de horas totales (normales + extras) trabajadas, fecha de término del contrato. Médico: especialidad (cirujano, oftalmólogo, etc.), servicio (cirugía, oftalmología, etc.), número de consultorio. La aplicación a desarrollar debe permitir: Registrar los datos de los empleados, los pacientes y los médicos. Registrar los datos de una cita médica. Listar los datos de los médicos por la especialidad. Listar los datos (nombres y apellidos) de los pacientes atendidos por un médico determinado 

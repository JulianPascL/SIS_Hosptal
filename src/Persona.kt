import java.time.LocalDate
import java.time.format.DateTimeFormatter

open class Persona(          //Clase general para persona
    val dni: String,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: LocalDate,
    val direccion: String,
    val ciudadProcedencia: String
)

class Paciente(             //Clase que hereda datos de OPEN CLASS PERSONA
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    direccion: String,
    ciudadProcedencia: String,
    val numeroHistoriaClinica: String,
    val sexo: String,
    val grupoSanguineo: String,
    val alergias: List<String>
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)

open class Empleado(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    direccion: String,
    ciudadProcedencia: String,
    val codigoEmpleado: String,
    val horasExtras: Int,
    val fechaIngreso: LocalDate,
    val area: String,
    val cargo: String
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)

 open class EmpleadoPlanilla(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: LocalDate,
    area: String,
    cargo: String,
    val salarioMensual: Double,
    val porcentajeAdicionalHoraExtra: Double
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)

class EmpleadoEventual(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: LocalDate,
    area: String,
    cargo: String,
    val honorariosPorHora: Double,
    val horasTotales: Int,
    val fechaTerminoContrato: LocalDate
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)

class Medico(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: LocalDate,
    area: String,
    cargo: String,
    salarioMensual: Double,
    porcentajeAdicionalHoraExtra: Double,
    val especialidad: String,
    val servicio: String,
    val numeroConsultorio: Int
) : EmpleadoPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra)

data class CitaMedica(
    val paciente: Paciente,
    val medico: Medico,
    val fecha: LocalDate,
    val hora: String
)

class Hospital {                        // Esta clase ayuda a llamar las listas que utilizaremos para guardar datos
    private val empleados = mutableListOf<Empleado>()
    private val pacientes = mutableListOf<Paciente>()
    private val medicos = mutableListOf<Medico>()
    private val citas = mutableListOf<CitaMedica>()


    // FUNCIONES PARA LAS ACCIONES DEL PROGRAMA

    fun registrarEmpleado() {
        println("Registrar empleado:")
        println("1. Empleado por Planilla")
        println("2. Empleado Eventual")
        print("Seleccione el tipo de empleado: ")
        when (readLine()!!.toInt()) {
            1 -> registrarEmpleadoPlanilla()
            2 -> registrarEmpleadoEventual()
            else -> println("Opción inválida")
        }
    }

    private fun registrarEmpleadoPlanilla() {
        val emp = solicitarDatosEmpleado()
        print("Salario mensual: ")
        val salarioMensual = readLine()!!.toDouble()
        print("Porcentaje adicional por hora extra: ")
        val porcentajeAdicional = readLine()!!.toDouble()

        val empleado = EmpleadoPlanilla(
            emp.dni, emp.nombre, emp.apellido, emp.fechaNacimiento, emp.direccion, emp.ciudadProcedencia,
            emp.codigoEmpleado, emp.horasExtras, emp.fechaIngreso, emp.area, emp.cargo,
            salarioMensual, porcentajeAdicional
        )
        empleados.add(empleado)
        println("Empleado por Planilla registrado con éxito.")
    }

    private fun registrarEmpleadoEventual() {
        val emp = solicitarDatosEmpleado()
        print("Honorarios por hora: ")
        val honorariosPorHora = readLine()!!.toDouble()
        print("Horas totales trabajadas: ")
        val horasTotales = readLine()!!.toInt()
        print("Fecha de término del contrato (dd/MM/yyyy): ")
        val fechaTermino = LocalDate.parse(readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))

        val empleado = EmpleadoEventual(
            emp.dni, emp.nombre, emp.apellido, emp.fechaNacimiento, emp.direccion, emp.ciudadProcedencia,
            emp.codigoEmpleado, emp.horasExtras, emp.fechaIngreso, emp.area, emp.cargo,
            honorariosPorHora, horasTotales, fechaTermino
        )
        empleados.add(empleado)
        println("Empleado Eventual registrado.")
    }

    private fun solicitarDatosEmpleado(): Empleado {
        print("DNI: ")
        val dni = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!!
        print("Apellido: ")
        val apellido = readLine()!!
        print("Fecha de nacimiento (dd/MM/yyyy): ")
        val fechaNacimiento = LocalDate.parse(readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        print("Dirección: ")
        val direccion = readLine()!!
        print("Ciudad de procedencia: ")
        val ciudadProcedencia = readLine()!!
        print("Código de empleado: ")
        val codigoEmpleado = readLine()!!
        print("Horas extras: ")
        val horasExtras = readLine()!!.toInt()
        print("Fecha de ingreso (dd/MM/yyyy): ")
        val fechaIngreso = LocalDate.parse(readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        print("Área: ")
        val area = readLine()!!
        print("Cargo: ")
        val cargo = readLine()!!

        return Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
            codigoEmpleado, horasExtras, fechaIngreso, area, cargo)
    }

    fun registrarPaciente() {
        print("DNI: ")
        val dni = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!!
        print("Apellido: ")
        val apellido = readLine()!!
        print("Fecha de nacimiento (dd/MM/yyyy): ")
        val fechaNacimiento = LocalDate.parse(readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        print("Dirección: ")
        val direccion = readLine()!!
        print("Ciudad de procedencia: ")
        val ciudadProcedencia = readLine()!!
        print("Número de historia clínica: ")
        val numeroHistoriaClinica = readLine()!!
        print("Sexo: ")
        val sexo = readLine()!!
        print("Grupo sanguíneo: ")
        val grupoSanguineo = readLine()!!
        print("Alergias (separadas por coma): ")
        val alergias = readLine()!!.split(",").map { it.trim() } //split: Divide la cadena de entrada utilizando la coma como separador, trim elimina los espacios.

        val paciente = Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
            numeroHistoriaClinica, sexo, grupoSanguineo, alergias)
        pacientes.add(paciente)
        println("Paciente registrado.")
    }

    fun registrarMedico() {
        val emp = solicitarDatosEmpleado()
        print("Salario mensual: ")
        val salarioMensual = readLine()!!.toDouble()
        print("Porcentaje adicional por hora extra: ")
        val porcentajeAdicional = readLine()!!.toDouble()
        print("Especialidad: ")
        val especialidad = readLine()!!
        print("Servicio: ")
        val servicio = readLine()!!
        print("Número de consultorio: ")
        val numeroConsultorio = readLine()!!.toInt()

        val medico = Medico(
            emp.dni, emp.nombre, emp.apellido, emp.fechaNacimiento, emp.direccion, emp.ciudadProcedencia,
            emp.codigoEmpleado, emp.horasExtras, emp.fechaIngreso, emp.area, emp.cargo,
            salarioMensual, porcentajeAdicional, especialidad, servicio, numeroConsultorio
        )
        medicos.add(medico)
        println("Médico registrado.")
    }

    fun registrarCitaMedica() {
        println("Registrar cita médica:")
        print("DNI del paciente: ")
        val dniPaciente = readLine()!!
        val paciente = pacientes.find { it.dni == dniPaciente }
        if (paciente == null) {
            println("Paciente no encontrado.")
            return
        }

        print("Código del médico: ")
        val codigoMedico = readLine()!!
        val medico = medicos.find { it.codigoEmpleado == codigoMedico }
        if (medico == null) {
            println("Médico no encontrado.")
            return
        }

        print("Fecha de la cita (dd/MM/yyyy): ")
        val fecha = LocalDate.parse(readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        print("Hora de la cita (HH:mm): ")
        val hora = readLine()!!

        val cita = CitaMedica(paciente, medico, fecha, hora)
        citas.add(cita)
        println("Cita médica registrada.")
    }
                                    //El uso de filter para filtrar las listas de acuerdo a la condicion
    fun listarMedicosPorEspecialidad() {
        print("Ingrese la especialidad: ")
        val especialidad = readLine()!!
        val medicosFiltrados = medicos.filter { it.especialidad.equals(especialidad, ignoreCase = true) }
        if (medicosFiltrados.isEmpty()) {
            println("No se encontraron médicos con esa especialidad.")
        } else {
            println("Médicos de la especialidad $especialidad:")
            medicosFiltrados.forEach { medico ->
                println("${medico.nombre} ${medico.apellido} - Consultorio: ${medico.numeroConsultorio}")
            }
        }
    }

    fun listarPacientesPorMedico() {                // distinctBy se utiliza para obtener una lista de elementos distintos basándose en una clave específica
        print("Ingrese el código del médico: ")
        val codigoMedico = readLine()!!
        val citasMedico = citas.filter { it.medico.codigoEmpleado == codigoMedico }
        if (citasMedico.isEmpty()) {
            println("No se encontraron citas para este médico.")
        } else {
            println("Pacientes atendidos por el médico con código $codigoMedico:")
            citasMedico.distinctBy { it.paciente.dni }.forEach { cita ->
                println("${cita.paciente.nombre} ${cita.paciente.apellido}")
            }
        }
    }
}

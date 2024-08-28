fun main() {
    val hospital = Hospital()
    while (true) {

        println("1. Ingresar empleado")
        println("2. Ingresar paciente")
        println("3. Ingresar médico")
        println("4. Ingresar cita médica")
        println("5. Listar médicos por especialidad")
        println("6. Listar pacientes por médico")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (readLine()!!.toInt()) {
            1 -> hospital.registrarEmpleado()
            2 -> hospital.registrarPaciente()
            3 -> hospital.registrarMedico()
            4 -> hospital.registrarCitaMedica()
            5 -> hospital.listarMedicosPorEspecialidad()
            6 -> hospital.listarPacientesPorMedico()
            7 -> {
                println("Gracias por utlizar el servicio")
                return
            }
            else -> println("Opción inválida")
        }
    }
}
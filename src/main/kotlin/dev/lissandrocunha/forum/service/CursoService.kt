package dev.lissandrocunha.forum.service

import dev.lissandrocunha.forum.model.Curso
import java.util.Arrays
import org.springframework.stereotype.Service

@Service
class CursoService(
    var cursos: List<Curso>
) {
    init {
        val curso = Curso(
            1,
            "Kotlin",
            "Linguagem de Programação"
        )
        cursos = Arrays.asList(curso)
    }

    fun buscaPorId(id: Long): Curso {
        return cursos.stream().filter { a ->
            a.id == id
        }.findFirst().get()
    }
}

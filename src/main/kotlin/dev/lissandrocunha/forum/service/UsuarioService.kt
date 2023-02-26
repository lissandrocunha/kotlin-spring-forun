package dev.lissandrocunha.forum.service

import dev.lissandrocunha.forum.model.Usuario
import java.util.Arrays
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario>
) {

    init {
        val usuario1 = Usuario(
            1,
            "Ana da Silva",
            "ana@email.com.br"
        )
        val usuario2 = Usuario(
            2,
            "Ana da Silva",
            "ana@email.com.br"
        )
        usuarios = Arrays.asList(usuario1, usuario2)
    }

    fun buscaPorId(id: Long): Usuario {
        return usuarios.stream().filter { a ->
            a.id == id
        }.findFirst().get()
    }
}

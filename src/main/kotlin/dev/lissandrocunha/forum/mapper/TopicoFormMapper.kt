package dev.lissandrocunha.forum.mapper

import dev.lissandrocunha.forum.dto.NovoTopicoForm
import dev.lissandrocunha.forum.model.Topico
import dev.lissandrocunha.forum.service.CursoService
import dev.lissandrocunha.forum.service.UsuarioService
import org.springframework.stereotype.Service

@Service
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(source: NovoTopicoForm): Topico {
        return Topico(
            titulo = source.titulo,
            mensagem = source.mensagem,
            curso = cursoService.buscaPorId(source.idCurso),
            autor = usuarioService.buscaPorId(source.idAutor)
        )
    }
}

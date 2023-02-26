package dev.lissandrocunha.forum.mapper

import dev.lissandrocunha.forum.dto.TopicoView
import dev.lissandrocunha.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(source: Topico): TopicoView {
        return TopicoView(
            id = source.id,
            titulo = source.titulo,
            mensagem = source.mensagem,
            status = source.status,
            dataCriacao = source.dataCriacao
        )
    }
}

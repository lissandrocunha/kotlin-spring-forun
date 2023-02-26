package dev.lissandrocunha.forum.service

import dev.lissandrocunha.forum.dto.NovoTopicoForm
import dev.lissandrocunha.forum.dto.TopicoView
import dev.lissandrocunha.forum.mapper.TopicoFormMapper
import dev.lissandrocunha.forum.mapper.TopicoViewMapper
import dev.lissandrocunha.forum.model.Topico
import java.util.stream.Collectors
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: NovoTopicoForm) {
        val topico = topicoFormMapper.map(dto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}

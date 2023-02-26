package dev.lissandrocunha.forum.service

import dev.lissandrocunha.forum.dto.AtualizarTopicoForm
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

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atualizar(form: AtualizarTopicoForm) {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topicos = topicos.minus(topico).plus(
            Topico(
                id = topico.id,
                titulo = form.titulo,
                mensagem = form.mensagem,
                curso = topico.curso,
                autor = topico.autor,
                responstas = topico.responstas,
                status = topico.status,
                dataCriacao = topico.dataCriacao
            )
        )
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicos = topicos.minus(topico)
    }
}

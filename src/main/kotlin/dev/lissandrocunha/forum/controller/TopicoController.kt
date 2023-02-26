package dev.lissandrocunha.forum.controller

import dev.lissandrocunha.forum.dto.AtualizarTopicoForm
import dev.lissandrocunha.forum.dto.NovoTopicoForm
import dev.lissandrocunha.forum.dto.TopicoView
import dev.lissandrocunha.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid
        form: NovoTopicoForm
    ) {
        service.cadastrar(form)
    }

    @PutMapping
    fun atualizar(
        @RequestBody @Valid
        form: AtualizarTopicoForm
    ) {
        service.atualizar(form)
    }

    @DeleteMapping("/{id}")
    fun deletar(
        @PathVariable id: Long
    ) {
        service.deletar(id)
    }
}

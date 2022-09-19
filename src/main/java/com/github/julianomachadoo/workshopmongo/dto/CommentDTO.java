package com.github.julianomachadoo.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {

    private String texto;
    private LocalDate data;
    private AuthorDTO authorDTO;

    public CommentDTO() {
    }

    public CommentDTO(String texto, LocalDate data, AuthorDTO authorDTO) {
        this.texto = texto;
        this.data = data;
        this.authorDTO = authorDTO;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}

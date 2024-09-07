package bo.com.bisablog.entity;

import bo.com.bisablog.entity.enums.Periodicidad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "blogs")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreTitulo;
	private String tema;
	private String contenido;
	@Enumerated(EnumType.STRING)
	private Periodicidad periodicidad;
	private Boolean habilitarComentario;

	@JoinTable(name = "blog_autor", 
			joinColumns = @JoinColumn(name = "blog_id", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "autor_id", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Autor> autores;

	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<Comentario>();

	public void addAutor(Autor autor) {
		if (this.autores == null) {
			this.autores = new ArrayList<>();
		}
		this.autores.add(autor);
	}

}

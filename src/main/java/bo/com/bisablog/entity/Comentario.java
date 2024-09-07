package bo.com.bisablog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String nombre;
    private String correoElectronico;
    private String paisResidencia;
    @Min(0)
    @Max(10)
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
}


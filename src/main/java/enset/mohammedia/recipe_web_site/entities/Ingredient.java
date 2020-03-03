package enset.mohammedia.recipe_web_site.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
@Getter
@Setter
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal amount;
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    private UnitOfMesure unitOfMesure;
    @ManyToOne
    private Recipe recipe;
}

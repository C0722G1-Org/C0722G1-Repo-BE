package form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDataForm;
    private String contentDataForm;
    private boolean flagDelete = false;
    @ManyToOne
    private DetailForm detailForm;
}

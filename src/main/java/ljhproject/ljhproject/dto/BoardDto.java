package ljhproject.ljhproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class BoardDto {
    private int b_Id;
    private String b_Title;
    private String b_Contents;
    private LocalDate b_Regdate;
    private int abc;
}

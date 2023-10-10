package ljhproject.ljhproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {

    @NotBlank(message = "공백 공백")
    String text;

    @NotBlank
    String password;

    @NotBlank
    String nickname;
}


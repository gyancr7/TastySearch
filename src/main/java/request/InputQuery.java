package request;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonSnakeCase
@NoArgsConstructor
public class InputQuery {

    @NotNull private List<String> queryTokens;
    @NotNull private int k;
    @NotNull private String filePath;
}

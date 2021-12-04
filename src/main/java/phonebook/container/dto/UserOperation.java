package phonebook.container.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import phonebook.container.enums.OperationStatuses;
import phonebook.container.enums.OperationTypes;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOperation {

    private String user_id;
    private OperationTypes operation_type;
    private OperationStatuses operation_status;

}

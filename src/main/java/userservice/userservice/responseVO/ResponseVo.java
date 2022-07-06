package userservice.userservice.responseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import userservice.userservice.entity.User;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {
    private User user;
    private Department department;

}

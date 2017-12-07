package dto;

import bo.SEX;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 *         Date: 2017-12-05
 *         Time: 15:44
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private int id;

    private String name;

    private int age;

    private SEX sex;

    private Date createdTime;

    private Date updatedTime;

}

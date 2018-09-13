package bean;



import javax.validation.constraints.*;

/**
 * @author yan
 * @date 2018/9/9 15:23
 * @descripition
 */
public class People {
    @NotNull(message = "必填")
    @Size(min = 2,max = 20,message = "名字长度不合规范")
    private String name;

    @NotNull(message = "必填")
    @Min(value = 0,message = "年龄不切实际")
    @Max(value=200,message = "年龄不切实际")
    private int age;
    @NotNull(message = "必填")
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",message = "电话号码格式不对")
    private String phone;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

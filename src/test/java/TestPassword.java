import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPassword {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String ans=passwordEncoder.encode("0709");
        System.out.println(ans);
        ans=passwordEncoder.encode("0709");
        System.out.println(ans);
        ans=passwordEncoder.encode("0709");
        System.out.println(ans);
    }
}

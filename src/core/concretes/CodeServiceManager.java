package core.concretes;
import core.abstractt.VerifyingCodeService;

import java.util.Random;
import java.util.Scanner;

public class CodeServiceManager implements VerifyingCodeService {

    @Override
    public void verifyingcode() {
        System.out.println("----Verification System----");
        Random random = new Random();
        int code = random.nextInt(3649);

        String code_2 = Integer.toString(code);
        System.out.println("Verifying Code: " + code);
        System.out.println("Enter the code sent for verification: ");
        Scanner input = new Scanner(System.in);
        String codeInput = input.nextLine();

        if(code_2.equals(codeInput)){
            System.out.println("Code verified and login completed successfully");
        }
        else {
            System.out.println("The code could not be verified");
        }



    }
}

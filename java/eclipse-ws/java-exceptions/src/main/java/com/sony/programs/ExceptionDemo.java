package com.sony.programs;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionDemo {
	// private static Logger log = LoggerFactory.getLogger(ExceptionDemo.class);

	public static void main(String[] args) {

		try {
			String input1 = args[0]; // "1234"
			String input2 = args[1]; // "ten"

			int num = Integer.parseInt(input1); // 1234
			int den = Integer.parseInt(input2);

			int quot = num / den; // 1234/0
			int rem = num % den;

			log.debug("{} / {} = {} with reminder {}", num, den, quot, rem);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			log.warn("Not enough parameters. Required 2 but got {}", args.length);
		}
		catch (ArithmeticException ex) {
			log.warn("Cannot divide an integer by zero");
			// System.exit(1); // exit to the OS
			return;
		}
		catch (NumberFormatException ex) {
			log.warn("Required only integers, but received {}", Arrays.toString(args));
		}
//		catch (Exception ex) {
//			log.warn("Something went wrong. Exception type is - {} and message is  - {}", ex.getClass().getName(),
//					ex.getMessage());
//		}
		finally {
			log.debug("This is from inside of finally block");
		}

		log.debug("End of main() reached");

	}

}

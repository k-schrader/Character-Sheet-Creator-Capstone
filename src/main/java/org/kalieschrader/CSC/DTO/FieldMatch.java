package org.kalieschrader.CSC.DTO;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//Here we are creating a custom annotation to validate if two fields in a class have the same value
@Target({ TYPE, ANNOTATION_TYPE }) // Lets us use the annotation on classes and other annotations
@Retention(RUNTIME) // Keeps the annotation available during runtime
@Constraint(validatedBy = FieldMatchValidator.class) // Uses FieldMatchValidator to perform the validation
@Documented //
public @interface FieldMatch {
	// Displays a default error message if validation fails
	String message() default "{constraints.field-match}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	// Names of the two fields to be compared
	String first();

	String second();

	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	// "List" lest us use the annotation multiple times
	@interface List {
		FieldMatch[] value();
	}
}

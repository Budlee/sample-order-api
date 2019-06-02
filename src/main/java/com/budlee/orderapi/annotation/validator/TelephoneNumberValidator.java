package com.budlee.orderapi.annotation.validator;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.budlee.orderapi.annotation.ValidTelephoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneNumberValidator implements ConstraintValidator<ValidTelephoneNumber, String> {
   public void initialize(ValidTelephoneNumber constraint) {
   }

   public boolean isValid(String number, ConstraintValidatorContext context) {
      try {
         PhoneNumberUtil.getInstance().parse(number,"GB");
      } catch (Exception e) {
         return false;
      }
      return true;
   }
}

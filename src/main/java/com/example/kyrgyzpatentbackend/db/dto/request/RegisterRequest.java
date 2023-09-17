package com.example.kyrgyzpatentbackend.db.dto.request;

import com.example.kyrgyzpatentbackend.validations.NameValid;
import com.example.kyrgyzpatentbackend.validations.PasswordValid;
import com.example.kyrgyzpatentbackend.validations.PhoneNumberValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RegisterRequest(
        @NotBlank(message = "Необходимо указать имя.")
        @NameValid(message = "Фамилия должно содержать от 2 до 33 символов.")
        String fullName,
        @NotBlank(message = "Номер телефона не должен быть пустым")
        @PhoneNumberValid(message = "Номер телефона должен начинаться с +996, состоять из 13 символов и должен быть действительным!")
        String phoneNumber,
        @NotBlank(message = "Почта не должна быть пустой")
        @Email(message = "Напишите действительный адрес электронной почты!")
        String email,
        @NotBlank(message = "Пароль не должен быть пустым")
        @PasswordValid(message = "Длина пароля должна быть более 8 символов и содержать как минимум одну заглавную букву!")
        String password
) {
}

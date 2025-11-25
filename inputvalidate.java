public static boolean isValidEmail(String email) {
    return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
}

public static boolean isValidPhone(String phone) {
    return phone != null && phone.matches("\\d{10}");
}

public static boolean isValidDate(String dateStr) {
    try {
        LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}

public static boolean isPositiveInteger(String str) {
    try {
        int value = Integer.parseInt(str);
        return value > 0;
    } catch (NumberFormatException e) {
        return false;
    }
}

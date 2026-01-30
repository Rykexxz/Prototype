package net.pokeapi.gender;


public enum Gender {
    MALE,
    FEMALE,
    GENDERLESS,
    UNKNOWN;

    @Override
    public String toString() {
        String s = name().toLowerCase().replace('_', ' ');
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}

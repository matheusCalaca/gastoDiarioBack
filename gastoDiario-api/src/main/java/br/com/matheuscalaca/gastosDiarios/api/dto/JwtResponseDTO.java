package br.com.matheuscalaca.gastosDiarios.api.dto;


public class JwtResponseDTO {
    private String accessToken;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // Construtor privado para impedir instâncias diretas
    private JwtResponseDTO() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    // Método estático para obter uma nova instância do Builder
    public static Builder builder() {
        return new Builder();
    }

    // Builder class
    public static class Builder {
        private String accessToken;

        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        // Método build para construir uma instância de JwtResponseDTO
        public JwtResponseDTO build() {
            JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
            jwtResponseDTO.setAccessToken(accessToken);
            return jwtResponseDTO;
        }
    }
}

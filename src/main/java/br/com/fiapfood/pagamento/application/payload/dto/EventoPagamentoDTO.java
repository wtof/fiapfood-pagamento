package br.com.fiapfood.pagamento.application.payload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventoPagamentoDTO {

    private String action;

    private String apiVersion;

    private String applicationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z 'UTC'")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateCreated;

    private String id;
    
    private boolean liveMode;

    private String type;

    @JsonProperty("user_id")
    private String userId;

    private DataMercadoPagoDTO data;
}


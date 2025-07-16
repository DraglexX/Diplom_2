package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class IdIngredient {
    @SerializedName("_id")
    private String id;

}

package com.devskiller.friendly_id.jackson;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import com.devskiller.friendly_id.Url62;

public class FriendlyIdDeserializer extends StdDeserializer<UUID> {

	public FriendlyIdDeserializer() {
		super(UUID.class);
	}

	@Override
	public UUID deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

		JsonToken token = parser.getCurrentToken();
		if (token == JsonToken.VALUE_STRING) {
			String string = parser.getValueAsString().trim();
			return Url62.decode(string);
		}
		throw new IllegalStateException("This is not friendly id");
	}
}

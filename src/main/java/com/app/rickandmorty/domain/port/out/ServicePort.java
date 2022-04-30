package com.app.rickandmorty.domain.port.out;

import com.app.rickandmorty.domain.model.out.CharacterDetail;

public interface ServicePort {
    public CharacterDetail getCharacterDetail(int id);
}

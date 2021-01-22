package com.formation.database;

import com.formation.database.models.Modeles;
import com.formation.database.models.Piece;
import com.formation.database.repository.ModeleRepository;
import com.formation.database.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    PieceRepository pieceRepository;

    @Autowired
    ModeleRepository modeleRepository;

    @GetMapping("/save")
    public String testInsert(){
        Modeles m = new Modeles();
        m.setNumeroModele("hdhhddhhh");
        m.setPiece(pieceRepository.findById(1L).get());
        m.setStock_reverse(333);
        m.setTaille(2222);

        modeleRepository.save(m);

        return "success";
    }
}

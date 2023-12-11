package com.team2.smarttowns.controller.web;

import com.google.gson.Gson;
import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;
import com.team2.smarttowns.service.RankService;
import com.team2.smarttowns.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RankWebController {

    private final RankService rankService;

    @Autowired
    public RankWebController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/rankweb")
//    ResponseEntity<List<Checkpoint>>
    public ModelAndView rankweb() {
        ModelAndView modelAndView=new ModelAndView("rank.html");
        //List<Checkpoint> checkpoints = rankService.getAllUserCheckpoints();

        List<UserAccessedCheckpointRank> checkpoints=rankService.getRankListSorted();
        System.out.println(checkpoints);
//        for (Checkpoint checkpoint : checkpoints) {
//            System.out.println(checkpoint);
//        }
        modelAndView.addObject("checkpoints",checkpoints);
        return modelAndView;
    }
}

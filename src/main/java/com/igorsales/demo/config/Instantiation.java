package com.igorsales.demo.config;

import com.igorsales.demo.domain.Post;
import com.igorsales.demo.domain.User;
import com.igorsales.demo.repository.PostRepository;
import com.igorsales.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User jose = new User(null, "Jose Carlos","josecarlos@gmail.com");
        User igor = new User(null, "Igor Sales","igorsales.fs@gmail.com");
        User carlos = new User(null, "Carlos Alberto","carlos@gmail.com");

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2018"), "#Partiu, Viajar","Vou Viajar para New York, bjs, abraços!", carlos);
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", jose);

        userRepository.saveAll(Arrays.asList(jose, igor, carlos));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}

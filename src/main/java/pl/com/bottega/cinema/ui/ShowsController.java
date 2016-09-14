package pl.com.bottega.cinema.ui;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CreateShowsRequest;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */
@RestController
@RequestMapping("/cinemas")
public class ShowsController {

    private AdminPanel adminPanel;

    public ShowsController(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    @PutMapping
    public void create(CreateShowsRequest request){
        adminPanel.createShow(request);
    }
}

package brax.quality.workoutlog.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import brax.quality.workoutlog.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link gifViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class gifViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String url;


    public gifViewFragment() {
        // Required empty public constructor
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment gifViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static gifViewFragment newInstance(String url) {
        gifViewFragment fragment = new gifViewFragment();
        fragment.setUrl(url);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // ((WebView)getView().findViewById(R.id.webview)).setWebViewClient(new WebViewClient());

        // add the url of gif
        //((WebView)getView().findViewById(R.id.webview)).loadUrl(url);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gif_view, container, false);
    }
}
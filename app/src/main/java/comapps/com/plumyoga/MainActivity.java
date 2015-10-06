package comapps.com.plumyoga;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity  {




    private WebView webView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.plumyoga_ic_launcher2);




        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#A41984"), PorterDuff.Mode.SRC_ATOP);

        String url = "http://www.plumyogadallas.com";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);





    }



    private class MyWebViewClient extends WebViewClient {
        @Override

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);

        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (url.startsWith("https://maps.google.com/maps")) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:32.8136511,-96.7699859" +
                        "?q=1924 Greenville Avenue, Dallas, Texas"));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);


            } else if (url.startsWith("https://www.facebook"))  {

                try{

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/644345482378709"));
                    startActivity(intent);

                }catch(Exception e){

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/644345482378709")));

                }

                return true;


            } else if (url.startsWith("http://instagram.com"))  {

                Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                intent.setComponent(new ComponentName("com.instagram.android", "com.instagram.android.activity.UrlHandlerActivity"));
                intent.setData(Uri.parse("http://instagram.com/_u/plumyogadallas"));
                startActivity(intent);

                return true;

            } else if (url.startsWith("https://twitter.com")) {

                Intent intent;
                String username = "plumyogadallas";
                try {
                    // get the Twitter app if possible

                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + username));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/plumyogadallas"));
                }

                startActivity(intent);
                return true;






            } else if (url.startsWith("https://www.pinterest.com")) {

                Intent intent;
                String username = "plumyogadallas";
                try {
                    // get the Twitter app if possible

                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("pinterest://pinterest.com/" + username));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pinterest.com/plumyogadallas"));
                }

                startActivity(intent);
                return true;

            }

                view.loadUrl(url);
            return true;
        }

        @Override

        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);

        }







    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent callIntent = new Intent(Intent.ACTION_VIEW);
            callIntent.setData(Uri.parse("tel:2147929918"));
            startActivity(callIntent);

            return true;
        }

        if (id == R.id.action_settings2) {
            Intent intent3 = new Intent(android.content.Intent.ACTION_SEND);
            intent3.setType("text/plain");String[] address = {"info@plumyogadallas.com"};

            intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address);
            intent3.putExtra(android.content.Intent.EXTRA_SUBJECT, "subject");
            intent3.putExtra(android.content.Intent.EXTRA_TEXT, "text");
            startActivityForResult((Intent.createChooser(intent3, "Email")), 1);

            return true;
        }

        if (id == R.id.action_settings3) {

            try{

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/644345482378709"));
                startActivity(intent);

            }catch(Exception e){

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/644345482378709")));

            }

            return true;
        }

        if (id == R.id.action_settings4) {

            Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
            intent.setComponent(new ComponentName("com.instagram.android", "com.instagram.android.activity.UrlHandlerActivity"));
            intent.setData(Uri.parse("http://instagram.com/_u/plumyogadallas"));
            startActivity(intent);

            return true;
        }

        if (id == R.id.action_settings5) {
            Intent intent;
            String username = "plumyogadallas";
            try {
                // get the Twitter app if possible
                this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + username));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Twitter app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/plumyogadallas"));
            }
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.action_settings6) {

            Intent intent;
            String username = "plumyogadallas";
            try {
                // get the Twitter app if possible

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("pinterest://pinterest.com/" + username));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Twitter app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pinterest.com/plumyogadallas"));
            }

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {

            webView.goBack();
        } else {

            super.onBackPressed();

        }
    }
}

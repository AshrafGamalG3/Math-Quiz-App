import android.os.Parcel
import android.os.Parcelable
import com.example.mathquizapp.question.Question
import java.util.ArrayList

data class QuestionListWrapper(
    val questions: ArrayList<Question>?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Question)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(questions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionListWrapper> {
        override fun createFromParcel(parcel: Parcel): QuestionListWrapper {
            return QuestionListWrapper(parcel)
        }

        override fun newArray(size: Int): Array<QuestionListWrapper?> {
            return arrayOfNulls(size)
        }
    }
}
